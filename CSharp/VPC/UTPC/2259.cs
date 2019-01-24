namespace vpc.utpc
{
    using System;
    using System.Linq;
    using System.Collections.Generic;

    class ans2259
    {
        static void Main()
        {
            var scores = new List<int>();
            foreach(String line in ReadLines().Skip(1)) {
                scores.Add(line.Split(' ').Select(x => int.Parse(x)).Sum());
            }
            Console.WriteLine(scores.Max());
        }

        static IEnumerable<string> ReadLines()
        {
            while (true)
            {
                var line = Console.ReadLine();
                if (line == null) break;
                yield return line;
            }
        }
    }
}

/*
dotnet build -p:StartupObject=vpc.utpc.ans2259 -o:.
 */
