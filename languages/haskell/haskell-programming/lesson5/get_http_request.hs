getHttpRequest host token resource id = host ++
                                      "/" ++
                                      resource ++
                                      "/" ++
                                      id ++
                                      "?token=" ++
                                      token

generateHostRequestBuilder host = (\token resource id ->
                                    getHttpRequest host token resource id)

generateApiTokenBuilder hostBuilder token = (\resource id ->
                                              hostBuilder token resource id)

{-
  host をクロージャにした例
  ghci> ex = generateHostRequestBuilder "http://example.com"
  ghci> ex "yourtoken" "hoge" "12345"
  "http://example.com/hoge/12345?token=yourtoken"
-}


{-
  ghci> ex = generateHostRequestBuilder "http://example.com"
  ghci> url = generateApiTokenBuilder yourtoken ex "12345"
  ghci> url "hogehoge" "123456"
  "http://example.com/hogehoge/123456?token=12345"
-}
