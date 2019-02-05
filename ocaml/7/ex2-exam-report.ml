(*
  Create exam result string
  generateReportByUser: (string * string) -> string
*)
let generateReportByUser pair = match pair with
  (name, score) -> name ^ " score is " ^ score

(* Unit test *)
let test1 = generateReportByUser ("Jhon doe", "S") = "Jhon doe score is S"
let test2 = generateReportByUser ("FooBar", "C") = "FooBar score is C"

(*
  #use "ex2-exam-report.ml";;

  Result
  -----------------------
  val generateReportByUser : string * string -> string = <fun>
  val test1 : bool = true
  val test2 : bool = true
*)
