cup f10z = \message -> message f10z
get0z aCup = aCup (\f10z -> f10z)

drink aCup ozDrank = cup (f10z - ozDrank)
  where f10z = get0z aCup
