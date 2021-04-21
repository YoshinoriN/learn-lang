putsTitle t = "Title: " ++ t ++ ",\n"
putsTag t = "Tag: " ++ t ++ ".\n"
putsCategory c = "Category: " ++ c

createPost title tag category = putsTitle title ++
                                putsTag tag ++
                                putsCategory category

main = do
  print "What is the title?"
  title <- getLine
  print "What is the tag?"
  tag <- getLine
  print "Who is the category?"
  category <- getLine
  print(createPost title tag category)
