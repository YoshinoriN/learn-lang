let list1 = [1; 2; 3; 4;]
let list2 = 1::2::3::4::[]
let list3 = 1::2::[3; 4;]

(*
  #use "list.ml";;

  Result
  -------------------------
  val list1 : int list = [1; 2; 3; 4]
  val list2 : int list = [1; 2; 3; 4]
  val list3 : int list = [1; 2; 3; 4]
*)
