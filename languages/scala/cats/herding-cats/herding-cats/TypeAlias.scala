object TypeAlias {
  type FirstName = String
  type LastName = String
  type PatientName = (FirstName, LastName)

  case class Human(name: PatientName)
}
