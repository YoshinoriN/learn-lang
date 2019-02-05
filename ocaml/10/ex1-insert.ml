(*
  Insert int to ascending sorted list
  insert: int list -> int -> int list
*)
let rec insert l n = match l with
  [] -> [n]
  | first :: rest ->
    if n > first then
      first :: (insert rest n)
    else
      n :: l

(* Unit test *)
let test1 = insert [] 10
let test2 = insert [1;2;3;4;5;6;7] 0
let test3 = insert [1;2;3;4;5;6;7] 8
let test4 = insert [1;2;3;5;6;7] 4

(*
  #use "ex1-insert.ml";;

  Result
  ---------------------
  val insert : 'a list -> 'a -> 'a list = <fun>
  val test1 : int list = [10]
  val test2 : int list = [0; 1; 2; 3; 4; 5; 6; 7]
  val test3 : int list = [1; 2; 3; 4; 5; 6; 7; 8]
  val test4 : int list = [1; 2; 3; 4; 5; 6; 7]
*)
