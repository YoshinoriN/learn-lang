namespace courses.itp1
{
    using System;
    using System.Linq;
    class ans4A
    {
        static void Main()
        {
            var nums = Console.ReadLine().Split(' ').Select(x => int.Parse(x)).ToArray();
            Console.WriteLine((nums[0] / nums[1]) + " " + (nums[0] % nums[1]) + " " + (Convert.ToDouble(nums[0]) / Convert.ToDouble(nums[1])).ToString("f5"));
        }
    }

}

/*
dotnet build -p:StartupObject=courses.itp1.ans4A -o:.
 */
