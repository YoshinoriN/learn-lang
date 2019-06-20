namespace courses.itp1
{
    using System;
    using System.Linq;
    class ans4B
    {
        static void Main()
        {
            var r = double.Parse(Console.ReadLine());
            var p = 3.141592653589;
            Console.WriteLine(((r * r) * p).ToString("f6") + " " +  ((r * 2) * p).ToString("f6"));
        }
    }
}

/*
dotnet build -p:StartupObject=courses.itp1.ans4B -o:.
 */
