(*
  get list length
  length: int list -> int
*)
let rec length l = match l with
  [] -> 0
  | first :: rest -> 1 + length rest

(* Unit test *)
let test1 = length [1; 2; 3; 4; 1;] = 5
let test2 = length [] = 0
let test3 = length [1] = 1
let test4 = length [3; 4; 1;] = 3

(*
  #use "ex4-recursiveListLength.ml";;

  Return
  ------------------------
  val length : 'a list -> int = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
*)
