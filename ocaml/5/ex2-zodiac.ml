(* 3/21 - 4/19 *)
let aries = "Aries"
(* 4/20 - 5/20 *)
let taurus = "Taurus"
(* 5/21 - 6/21 *)
let gemini = "Gemini"
(* 6/22 - 7/22 *)
let cancer = "Cancer"
(* 7/23 - 8/22 *)
let leo = "Leo"
(* 8/23 - 9/22 *)
let virgo = "Virgo"
(* 9/23 - 10/23 *)
let libra = "Libra"
(* 10/24 - 11/22 *)
let scorpio = "Scorpio"
(* 11/22 - 12/23 *)
let sagittarius = "Sagittarius"
(* 12/24 - 1/19 *)
let capricorn = "Capricorn"
(* 1/20 - 2/18 *)
let aquarius = "Aquarius"
(* 2/19 - 3/20 *)
let pisces = "Pisces"

(*
  Get zodiac from month and day
  getZodiac int -> int -> string
*)
let getZodiac month day =
  if (month = 1 && day <= 20) || (month = 2 && day <= 18) then
    aquarius
  else if (month = 2 && day <= 19) || (month = 3 && day <= 20) then
    pisces
  else if (month = 3 && day <= 21) || (month = 4 && day <= 19) then
    aries
  else if (month = 4 && day <= 20) || (month = 5 && day <= 20) then
    taurus
  else if (month = 5 && day <= 21) || (month = 6 && day <= 21) then
    gemini
  else if (month = 6 && day <= 22) || (month = 7 && day <= 22) then
    cancer
  else if (month = 7 && day <= 23) || (month = 8 && day <= 22) then
    leo
  else if (month = 8 && day <= 23) || (month = 9 && day <= 22) then
    virgo
  else if (month = 9 && day <= 23) || (month = 10 && day <= 23) then
    libra
  else if (month = 10 && day <= 24) || (month = 11 && day <= 22) then
    scorpio
  else if (month = 11 && day <= 22) || (month = 12 && day <= 23) then
    sagittarius
  else if (month = 12 && day <= 24) || (month = 1 && day <= 19) then
    capricorn
  else
    "Unknown"

(* Unit test *)
let test1 = getZodiac 3 20 = pisces
let test2 = getZodiac 3 21 = aries
let test3 = getZodiac 4 19 = aries
let test4 = getZodiac 4 20 = taurus
let test5 = getZodiac 13 0 = "Unknown"

(*
  #use "ex2-zodiac.ml";;

  Result
  -------------------------
  val aries : string = "Aries"
  val taurus : string = "Taurus"
  val gemini : string = "Gemini"
  val cancer : string = "Cancer"
  val leo : string = "Leo"
  val virgo : string = "Virgo"
  val libra : string = "Libra"
  val scorpio : string = "Scorpio"
  val sagittarius : string = "Sagittarius"
  val capricorn : string = "Capricorn"
  val aquarius : string = "Aquarius"
  val pisces : string = "Pisces"
  val getZodiac : int -> int -> string = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test4 : bool = true
  val test5 : bool = true
*)
