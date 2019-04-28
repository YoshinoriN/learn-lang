type personType = {name : string; bloodType :string;}

let p1 = {name = "Bob"; bloodType = "A";}
let p2 = {name = "Dee"; bloodType = "B";}
let p3 = {name = "Joo"; bloodType = "A";}
let p4 = {name = "Paa"; bloodType = "B";}

(*
  Count number of blood type A person
  countBloodTypeA: personType list -> int
*)
let rec countBloodTypeA persons = match persons with
  [] -> 0
  | (personType as first) :: rest ->
    if first.bloodType = "A" then
      1 + countBloodTypeA rest
    else
      countBloodTypeA rest

(* Unit test *)
let test1 = countBloodTypeA []
let test2 = countBloodTypeA [p1; p2; p3; p4;]
let test3 = countBloodTypeA [p2; p4;]

(*
  #use "ex7-recursiveTypeListCount.ml";;

  Result
  ----------------------------
  type personType = { name : string; bloodType : string; }
  val p1 : personType = {name = "Bob"; bloodType = "A"}
  val p2 : personType = {name = "Dee"; bloodType = "B"}
  val p3 : personType = {name = "Joo"; bloodType = "A"}
  val p4 : personType = {name = "Paa"; bloodType = "B"}
  val countBloodTypeA : personType list -> int = <fun>
  val test1 : int = 0
  val test2 : int = 2
  val test3 : int = 0
*)
