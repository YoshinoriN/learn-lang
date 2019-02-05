type personType = {
  name : string;
  bloodType : string;
}

let p1 = {
  name = "Hoge";
  bloodType = "A";
}

let p2 = {
  name = "Foo";
  bloodType = "B";
}

(*
  Display blood type by person.
  displayBloodType: personType -> string
*)
let displayBloodType person = match person with
  { name = n; bloodType = b; } -> n ^ "'s blood type is " ^ b

(* Unit test *)
let test1 = displayBloodType p1 = "Hoge's blood type is A"
let test2 = displayBloodType p2 = "Foo's blood type is B"

(*
  #use "ex4-personMatch.ml";;

  Result
  --------------------
  type personType = { name : string; bloodType : string; }
  val p1 : personType = {name = "Hoge"; bloodType = "A"}
  val p2 : personType = {name = "Foo"; bloodType = "B"}
  val displayBloodType : personType -> string = <fun>
  val test1 : bool = true
  val test2 : bool = true
*)
