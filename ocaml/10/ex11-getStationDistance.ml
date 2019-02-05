#use "../utils/station/stationDistanceData.ml";;

(*
  Get station distance
  getStationDistance : string -> string -> stationDistanceType -> float
*)
let rec getStationDistance s1 s2 list = match list with
  [] -> infinity
  | stationDistanceType :: rest ->
    if (s1 = stationDistanceType.start && s2 = stationDistanceType.finish) then
      stationDistanceType.distance
    else if (s2 = stationDistanceType.start && s1 = stationDistanceType.finish) then
      stationDistanceType.distance
    else
      getStationDistance s1 s2 rest

(* Unit test *)
let test1 = getStationDistance "yoyogiuehara" "yoyogikouen" stationDistances = 1.0
let test2 = getStationDistance "yoyogiuehara" "omotesandou" stationDistances = infinity
let test3 = getStationDistance "sendagi" "nishinippori" stationDistances = 0.9
let test4 = getStationDistance "nishinippori" "nishinippori" stationDistances = infinity

(*
  #use "ex11-getStationDistance.ml";;

  Result
  ----------------------------------------------
  val getStationDistance :
    string -> string -> stationDistanceType list -> float = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test4 : bool = true
*)

