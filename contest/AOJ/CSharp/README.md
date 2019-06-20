## Build

```sh
dotnet build -p:StartupObject=<namespace>.<className> -o:<out filePath>
```

## Exec

```sh
cat data.txt | dotnet csharp.dll
```

## Sample Code

```cs
using System;

namespace csharp
{
    class example
    {
        static void Main()
        {
            var lines = Console.In.ReadToEnd().Split(Environment.NewLine);
            foreach(String x in lines) {
                Console.WriteLine(x);
            }
        }
    }
}
```
