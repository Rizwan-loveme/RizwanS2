# Shizuku — plan update after 4A: finer split of 4B, 4C, 4E and of steps 5 - 8

Request: split 4B into several smaller parts, and split any other step of the same size the same way. Based on `RizwanS2-main-shizuku-step4a.zip`.

Only `shizuku/README.md` changed (plan table, "Step 4" table, new section "Steps 5 - 8, sub-steps"). No code, script or manifest was touched.

- 4B -> 4B-1 guard mechanism (decision), 4B-2 apply the removal, 4B-3 match check, 4B-4 notes + zip.
- 4C -> 4C-1 drop the `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` removal, 4C-2 patch self-check + rerun, 4C-3 permission ownership, 4C-4 duplicates re-check.
- 4E -> 4E-1 checker skeleton, 4E-2 provider rules, 4E-3 permission rules, 4E-4 component / string rules.
- 4A done; 4D, 4F, 4G unchanged.
- Step 5 -> 5A - 5D, step 6 -> 6A - 6E, step 7 -> 7A - 7E, step 8 -> 8A - 8F. Steps 9, 10 unchanged.

Next: 4B-1.
