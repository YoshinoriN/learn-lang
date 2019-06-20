namespace joi.prelim
{
    using System;
    class ans0630
    {
        static void Main()
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());
            var d = int.Parse(Console.ReadLine());
            var e = int.Parse(Console.ReadLine());

            if (a > 0) {
                Console.WriteLine((b - a) * e);
            } else {
                Console.WriteLine((Math.Abs(0 - a) * c) + (b - 0) * e + d);
            }
        }
    }
}

/*
dotnet build -p:StartupObject=joi.prelim.ans0630 -o:.
 */
