#use "ex1-insert.ml"

(*
  Ascending sort
  insertSort: int list -> int list
*)
let rec insertSort l = match l with
  [] -> []
  | first :: rest -> insert (insertSort rest) first

(* Unit test *)
let test1 = insertSort[2;1;5;7;3;1;]
let test2 = insertSort[0;0;1;4;0;]
let test3 = insertSort[]

(*
  #use "ex2-insertionSort.ml";;

  Result
  ---------------------
  val insertSort : 'a list -> 'a list = <fun>
  val test1 : int list = [1; 1; 2; 3; 5; 7]
  val test2 : int list = [0; 0; 0; 1; 4]
  val test3 : 'a list = []
*)
