#!/usr/bin/env python3
"""One-off step 3 tool (kept for the record): prefixes every resource of the upstream MAME4droid frontend with `mm_`
so nothing in :mame can clash with / silently override a resource of :app or another module.
Handles: file resources (drawable, layout, raw, xml, mipmap), value resources (string, color, style, array),
references @type/name, ?type/name, style parents, R.type.name in Java, android:name-free manifest references.
Ids (@+id/x, R.id.x) are NOT renamed (an id name cannot override anything); android.R.* and @android:* are never touched.
Usage (from the project root, on a fresh copy of upstream's res/ + java/):  python3 mame/tools/rename-resources.py
"""
import os, re, sys, json, collections
import xml.etree.ElementTree as ET
P = 'mm_'
ROOT = 'mame/src/main'
RES = f'{ROOT}/res'
FILE_TYPES = {'drawable', 'layout', 'raw', 'xml', 'mipmap', 'anim', 'menu', 'color', 'animator'}
VAL_TAG = {'string': 'string', 'string-array': 'array', 'array': 'array', 'integer-array': 'array', 'color': 'color',
           'style': 'style', 'dimen': 'dimen', 'integer': 'integer', 'bool': 'bool', 'plurals': 'plurals'}

names = collections.defaultdict(set)          # type -> {old names (as written)}
# 1. collect
for d in sorted(os.listdir(RES)):
    t = d.split('-')[0]
    if t == 'values':
        for f in os.listdir(f'{RES}/{d}'):
            for e in ET.parse(f'{RES}/{d}/{f}').getroot():
                n = e.get('name')
                if n and e.tag in VAL_TAG:
                    names[VAL_TAG[e.tag]].add(n)
    elif t in FILE_TYPES:
        for f in os.listdir(f'{RES}/{d}'):
            base = f.split('.')[0]
            names[t].add(base)
# 2. rename files
for d in sorted(os.listdir(RES)):
    t = d.split('-')[0]
    if t in FILE_TYPES and t != 'values':
        for f in os.listdir(f'{RES}/{d}'):
            if not f.startswith(P):
                os.rename(f'{RES}/{d}/{f}', f'{RES}/{d}/{P}{f}')

def rx_ref(types):
    return re.compile(r'(@|\?)(?!android:)(' + '|'.join(map(re.escape, types)) + r')/([A-Za-z0-9_.]+)')

def fix_ref(m):
    kind, t, n = m.group(1), m.group(2), m.group(3)
    if n in names.get(t, ()) and not n.startswith(P):
        return f'{kind}{t}/{P}{n}'
    return m.group(0)

REF = rx_ref(list(names.keys()))
changed = collections.Counter()
# 3. rewrite XML (res + manifest later)
def rewrite_xml(path):
    s = open(path, encoding='utf-8').read()
    o = s
    s = REF.sub(fix_ref, s)
    if '/values' in path.replace('\\', '/'):
        def defn(m):
            tag, n = m.group(1), m.group(2)
            t = VAL_TAG.get(tag)
            if t and n in names[t] and not n.startswith(P):
                return f'<{tag} name="{P}{n}"'
            return m.group(0)
        s = re.sub(r'<([a-z\-]+)\s+name="([A-Za-z0-9_.]+)"', defn, s)
        # style parents written as plain names (parent="Theme.MAME4droid")
        def parent(m):
            n = m.group(1)
            return f'parent="{P}{n}"' if n in names['style'] and not n.startswith(P) else m.group(0)
        s = re.sub(r'parent="([A-Za-z0-9_.]+)"', parent, s)
    if s != o:
        open(path, 'w', encoding='utf-8').write(s); changed['xml'] += 1
for dp, dn, fn in os.walk(RES):
    for f in fn:
        if f.endswith('.xml'):
            rewrite_xml(os.path.join(dp, f))
# 4. Java: R.type.name (not android.R.)
JT = {'string': 'string', 'array': 'array', 'color': 'color', 'style': 'style', 'drawable': 'drawable', 'layout': 'layout',
      'raw': 'raw', 'xml': 'xml', 'mipmap': 'mipmap', 'dimen': 'dimen', 'integer': 'integer', 'bool': 'bool', 'plurals': 'plurals', 'anim': 'anim', 'menu': 'menu'}
# plain R.x.y and the fully qualified com.seleuco.mame4droid.R.x.y (upstream uses both); android.R.x.y is never touched
JR = re.compile(r'((?<![\w.])|(?<=com\.seleuco\.mame4droid\.))R\.(' + '|'.join(JT) + r')\.([A-Za-z0-9_]+)')
def jfix(m):
    t, n = m.group(2), m.group(3)
    cands = [n, n.replace('_', '.')]   # style names with dots are written with underscores in R
    for c in cands:
        if c in names.get(t, ()):
            return f'R.{t}.{P}{n}'
    return m.group(0)
for dp, dn, fn in os.walk(f'{ROOT}/java'):
    for f in fn:
        if f.endswith('.java'):
            p = os.path.join(dp, f); s = open(p, encoding='utf-8').read(); s2 = JR.sub(jfix, s)
            if s2 != s: open(p, 'w', encoding='utf-8').write(s2); changed['java'] += 1
json.dump({k: sorted(v) for k, v in names.items()}, open('mame/tools/resource-names.json', 'w'), indent=1)
print(dict(changed), {k: len(v) for k, v in names.items()})
