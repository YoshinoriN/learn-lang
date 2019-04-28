type bookType = {
  title : string;
  author : string;
  publisher : string;
  price : int;
  isbn : string;
}

let book1 = {
  title = "Hoge";
  author = "Bar";
  publisher = "Foo";
  price = 900;
  isbn = "DDDDD";
}

let book2 = {
  title = "PEPEPE";
  author = "Bar";
  publisher = "Foo";
  price = 1900;
  isbn = "DCCVV";
}

let book3 = {
  title= "POPOPOP";
  author= "Bar";
  publisher= "FooXC";
  price= 12900;
  isbn= "GGBB";
}

(*
  #use "ex1-bookRecord.ml";;

  Result
  --------------------
  type bookType = {
    title : string;
    author : string;
    publisher : string;
    price : int;
    isbn : string;
  }
  val book1 : bookType =
    {title = "Hoge"; author = "Bar"; publisher = "Foo"; price = 900;
    isbn = "DDDDD"}
  val book2 : bookType =
    {title = "PEPEPE"; author = "Bar"; publisher = "Foo"; price = 1900;
    isbn = "DCCVV"}
  val book3 : bookType =
    {title = "POPOPOP"; author = "Bar"; publisher = "FooXC"; price = 12900;
    isbn = "GGBB"}
*)
