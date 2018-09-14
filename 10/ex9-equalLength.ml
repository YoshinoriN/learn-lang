
(*
  Two lists length are the same or not
  equalLength : list -> list -> bool
*)
let rec equalLength list1 list2 = match (list1, list2) with
    ([], []) -> true
  | ([], first) -> false
  | (first, []) -> false
  | (first1 :: rest1, first2 :: rest2) -> equalLength rest1 rest2

(* Unit test *)
let test1 = equalLength [][] = true
let test2 = equalLength [][1] = false
let test3 = equalLength [1][] = false
let test4 = equalLength [1; 2; 3][1; 2] = false
let test5 = equalLength [1; 2][1; 2; 3] = false
let test6 = equalLength [1; 2; 3][1; 2; 3] = true

(*
  #use "ex9-equalLength.ml";;

  Result
  ---------------
  val equalLength : 'a list -> 'b list -> bool = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test4 : bool = true
  val test5 : bool = true
  val test6 : bool = true
*)
