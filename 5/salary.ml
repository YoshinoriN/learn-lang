let saralyByHour = 950
let saralyBase = 100
let additionalSalaryByHour = saralyByHour + 30

(*
  Calc saraly
  saraly: int -> int
*)
let saraly hour = saralyBase + hour * (if hour < 30 then saralyByHour else additionalSalaryByHour)

(* Unit test *)
let test = saraly 1 = 1050
let test2 = saraly 29 = 27650
let test3 = saraly 30 = 29500

(*
  #use "salary.ml";;

  Result
  val saralyByHour : int = 950
  val saralyBase : int = 100
  val additionalSalaryByHour : int = 980
  val saraly : int -> int = <fun>
  val test : bool = true
  val test2 : bool = true
  val test3 : bool = true
*)
