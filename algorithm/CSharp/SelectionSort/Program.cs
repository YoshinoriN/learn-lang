namespace SelectionSort
{
    using System;
    using System.Linq;
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());
            var nums = Console.ReadLine().Split(' ').Select(x => int.Parse(x)).ToArray();
            var minj = 0;
            var swapCnt = 0; //AOJ提出用

            for (var i = 0; i < n; i++)
            {
                minj = i;
                for (var j = minj; j < n; j++)
                {
                    if (nums[j] < nums[minj])
                    {
                        minj = j;
                    }
                }
                //このifのところはAOJ提出用
                if (i != minj) {
                    var tmp = nums[i];
                    nums[i] = nums[minj];
                    nums[minj] = tmp;
                    swapCnt++;
                }
            }

            foreach (var x in nums)
            {
                Console.Write("{0} ", x);
            };
            //ここから先もAOJ提出用
            Console.WriteLine();
            Console.WriteLine(swapCnt);
        }
    }
}

/*
dotnet build -p:StartupObject=SelectionSort.Program -o:./

---------------
input example
6
5 6 4 2 1 3

---------------
output example
1 2 3 4 5 6
5

*/
