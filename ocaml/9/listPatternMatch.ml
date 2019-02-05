let patternMatch list = match list with
  [] -> 0
  | first :: rest -> first

let x = patternMatch []
let y = patternMatch [1; 2; 3]

(*
  #use "listPatternMatch.ml";;

  Result
  -------------------------
  val patternMatch : int list -> int = <fun>
  val x : int = 0
  val y : int = 1
*)
