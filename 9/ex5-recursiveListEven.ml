(*
  get even in list
  getEven: int list -> int list
*)
let rec getEven l = match l with
  [] -> []
  | first :: rest ->
    if first mod 2 = 0 then
      first :: getEven rest
    else
      getEven rest

(* Unit test *)
let test1 = getEven [1; 2; 3; 4; 1; 6; 8;]
let test2 = getEven []
let test3 = getEven [3; 3; 1;]
let test4 = getEven [8; 2; 4;]

(*
  #use "ex5-recursiveListEven.ml";;

  Return
  ------------------------
  val getEven : int list -> int list = <fun>
  val test1 : int list = [2; 4; 6; 8]
  val test2 : int list = []
  val test3 : int list = []
  val test4 : int list = [8; 2; 4]
*)
