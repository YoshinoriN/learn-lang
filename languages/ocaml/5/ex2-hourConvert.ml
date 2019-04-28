let morning = "morning"
let evening = "evening"

(*
  Convert hour(int) to morning(string) or evening(string)
  hourConverter -> int -> string
*)
let hourConverter hour =
  if hour >= 0 && hour < 13 then
    morning
  else
    evening

(* Unit test *)
let test1 = hourConverter 0 = morning
let test2 = hourConverter 1 = morning
let test3 = hourConverter 11 = morning
let test4 = hourConverter 13 = evening
let test4 = hourConverter 23 = evening


(*
  #use "ex2-hourConvert.ml";;

  Result
  ---------------------------------
  val morning : string = "morning"
  val evening : string = "evening"
  val hourConverter : int -> string = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test4 : bool = true
  val test4 : bool = true
*)
