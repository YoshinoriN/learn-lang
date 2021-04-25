-- first class func
ifEven f x = if even x
             then f x
             else x

incF n = n + 1
doubleF n = n * 2
squareF n = n ^ 2

ifEvenInc n = ifEven incF n
ifEvenDouble n = ifEven doubleF n
ifEvenSquare n = ifEven squareF n
