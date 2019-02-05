(*
  Return reversed x coordinate using by x,y coordinate
  calcReversedXCoordinate: (float * float) -> (float * float)
*)
let calcReversedXCoordinate coordinate = match coordinate with
  (x, y) -> (x, -. y)

(* Unit test *)
let test1 = calcReversedXCoordinate (3.45, 9.01) = (3.45, -9.01)

(*
  #use "ex3-xycoordinate1.ml";;

  Result
  ---------------------------
  val calcReversedXCoordinate : 'a * float -> 'a * float = <fun>
  val test1 : bool = true
*)
