var halvesAreAlike = function(s) {
  const replacedS = s.toLowerCase().replace(/a|e|i|o|u/g,'_');
  const m = s.length / 2;
  const firstHalf = replacedS.substr(0, m);
  const secondHalf = replacedS.slice(m, replacedS.length);

  return (firstHalf.match(/_/g) || []).length === (secondHalf.match(/_/g) || []).length;
};


console.log(halvesAreAlike("book"));
console.log(halvesAreAlike("textbook"));
console.log(halvesAreAlike("MerryChristmas"));
console.log(halvesAreAlike("AbCdEfGh"));
console.log(halvesAreAlike("gggg"));
