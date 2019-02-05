(*
  Return center x,y coordinate using by two x,y coordinates
  calcCenterCoordinate: (float * float)(float * float) -> (float * float)
*)
let calcCenterCoordinate coordinate1 coordinate2 = match coordinate1 with
  (x1, y1) -> (
    match coordinate2 with
      (x2, y2) -> ((x1 +. x2) /. 2.0, (y1 +. y2) /. 2.0)
  )

(* Unit test *)
let test1 = calcCenterCoordinate (2.2, 4.4)(4.1, 10.2) = (3.15, 7.3)

(*
  #use "ex3-xycoordinate2.ml";;

  Result
  ---------------------------
val calcCenterCoordinate : float * float -> float * float -> float * float = <fun>
val test1 : bool = true
*)
