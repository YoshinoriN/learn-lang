(*
  Concat string list
  concatString: string list -> string
*)
let rec concatString l = match l with
  [] -> ""
  | first :: rest ->
    first ^ concatString rest

(* Unit test *)
let test1 = concatString ["a"; "a"; "b"; "e";]
let test2 = concatString []
let test3 = concatString ["a"]
let test4 = concatString ["a"; "c"; ""; "c";]

(*
  #use "ex6-recursiveListConcat.ml";;

  Return
  ------------------------
  val concatString : string list -> string = <fun>
  val test1 : string = "aabe"
  val test2 : string = ""
  val test3 : string = "a"
  val test4 : string = "acc"
*)
