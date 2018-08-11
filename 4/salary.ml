
let saralyByHour = 950
let saralyBase = 100
(* 
  Calc saraly 
  saraly: int -> int
*)
let saraly hour = saralyBase + saralyByHour * hour

(* Unit test *)
let test = saraly 1 = 1050
let test2 = saraly 10 = 9600
let test3 = saraly 11 = 10550

(*
#use "salary.ml";;

Result
val saralyByHour : int = 950
val saralyBase : int = 100
val saraly : int -> int = <fun>
val test : bool = true
val test2 : bool = true
val test3 : bool = true
*)