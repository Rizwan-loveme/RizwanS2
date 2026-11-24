#!/usr/bin/env python3
"""Seal part 10: whole-project static check (no Gradle / SDK needed).
Usage: python3 seal/tools/static-check.py <project root>
Checks: every .xml parses, every workflow .yml parses, brackets of every .kt / .kts / .java are balanced (string / comment aware).
Known false positives (checked with javac, files are not Seal's): Bcore BundleInfo.java, mame NetPlayHelper.java (char literals of braces).
Exit code is not set; read the ERRORS line."""
import sys, os, re, glob
import xml.etree.ElementTree as ET
root = sys.argv[1]
errs=[]; notes=[]
def err(m): errs.append(m)

# 1. XML
nx=0
for dp,dn,fn in os.walk(root):
    if '/.git' in dp: continue
    for f in fn:
        if f.endswith('.xml'):
            p=os.path.join(dp,f); nx+=1
            try: ET.parse(p)
            except Exception as e: err(f"XML {p}: {e}")
notes.append(f"xml files parsed: {nx}")

# 2. YAML
try:
    import yaml
    ny=0
    for p in glob.glob(root+'/.github/workflows/*.y*ml'):
        ny+=1
        try: yaml.safe_load(open(p))
        except Exception as e: err(f"YAML {p}: {e}")
    notes.append(f"yaml parsed: {ny}")
except ImportError:
    notes.append("pyyaml missing")

# 3. bracket balance (string/comment aware) for kt/kts/java
def balanced(src):
    st=[]; i=0; n=len(src); pairs={')':'(',']':'[','}':'{'}
    # stack entries: '(' '[' '{' or ('T',) template brace
    while i<n:
        c=src[i]
        if src.startswith('//',i):
            j=src.find('\n',i); i = n if j<0 else j; continue
        if src.startswith('/*',i):
            d=1; i+=2
            while i<n and d:
                if src.startswith('/*',i): d+=1; i+=2
                elif src.startswith('*/',i): d-=1; i+=2
                else: i+=1
            continue
        if src.startswith('"""',i):
            i+=3
            while i<n and not src.startswith('"""',i):
                if src.startswith('${',i):
                    # skip nested template roughly
                    d=1; i+=2
                    while i<n and d:
                        if src[i]=='{': d+=1
                        elif src[i]=='}': d-=1
                        i+=1
                else: i+=1
            i+=3
            while i<n and src[i]=='"': i+=1
            continue
        if c=='"':
            i+=1
            while i<n and src[i]!='"':
                if src[i]=='\\': i+=2; continue
                if src.startswith('${',i):
                    d=1; i+=2
                    while i<n and d:
                        if src[i]=='{': d+=1
                        elif src[i]=='}': d-=1
                        elif src[i]=='"':
                            i+=1
                            while i<n and src[i]!='"':
                                if src[i]=='\\': i+=1
                                i+=1
                        i+=1
                    continue
                if src[i]=='\n': return f"newline in string line {src[:i].count(chr(10))+1}"
                i+=1
            i+=1; continue
        if c=="'":
            j=i+1
            if j<n and src[j]=='\\':
                k=src.find("'",j+2)
                i=k+1 if k>0 else i+1
            elif j+1<n and src[j+1]=="'": i=j+2
            elif j<n and src[j]!="'" and j+1<n and src[j+1]=="'": i=j+2
            else: i+=1
            continue
        if c in '([{': st.append(c)
        elif c in ')]}':
            if not st or st[-1]!=pairs[c]: return f"mismatch {c} at {src[:i].count(chr(10))+1}"
            st.pop()
        i+=1
    return None if not st else f"unclosed {st[-3:]}"
nk=0
for dp,dn,fn in os.walk(root):
    if '/.git' in dp or '/schemas' in dp: continue
    for f in fn:
        if f.endswith(('.kt','.kts','.java')):
            p=os.path.join(dp,f); nk+=1
            r=balanced(open(p,encoding='utf-8',errors='replace').read())
            if r: err(f"BRACKET {p}: {r}")
notes.append(f"kotlin/gradle/java balanced-checked: {nk}")
print("\n".join(notes))
print("ERRORS:",len(errs))
for e in errs: print(" ",e)
