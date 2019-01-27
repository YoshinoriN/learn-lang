using System;
using System.Diagnostics;
using System.Collections.Generic;

namespace ListLinkedList
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch sw = new Stopwatch();

            //挿入
            List<int> list = new List<int>();
            sw.Start();
            for(int i=0; i<=100000; i++)
            {
                list.Add(i);
            }
            sw.Stop();
            Console.WriteLine("List: Insert {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();

            LinkedList<int> linkedList = new LinkedList<int>();
            sw.Start();
            for(int i=0; i<=100000; i++)
            {
                linkedList.AddLast(i);
            }
            sw.Stop();
            Console.WriteLine("LinkedList: Insert {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();

            //参照
            sw.Start();
            var tmp = 0;
            foreach(var x in list)
            {
                tmp = x;
            }
            sw.Stop();
            Console.WriteLine("List: reference {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();

            sw.Start();
            foreach(var x in linkedList)
            {
                tmp = x;
            }
            sw.Stop();
            Console.WriteLine("LinkedList: reference {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();

            //削除
            sw.Start();
            for(int i=0; i<=100000; i++)
            {
                list.Remove(i);
            }
            sw.Stop();
            Console.WriteLine("List: remove {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();

            sw.Start();
            for(int i=0; i<=100000; i++)
            {
                linkedList.Remove(i);
            }
            sw.Stop();
            Console.WriteLine("LinkedList: remove {0} ms", sw.Elapsed.TotalMilliseconds);
            sw.Reset();
        }
    }
}

/*
dotnet build -p:StartupObject=ListLinkedList.Program -o:./
 */
