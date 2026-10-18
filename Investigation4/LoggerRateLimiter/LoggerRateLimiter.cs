public class LoggerRateLimiter
{

    public static void Main(String[] args)
    {
        Logger logger = new();
        Console.WriteLine(logger.ShouldPrintMessage(1,"foo"));
        Console.WriteLine(logger.ShouldPrintMessage(2,"bar"));
        Console.WriteLine(logger.ShouldPrintMessage(3,"foo"));
        Console.WriteLine(logger.ShouldPrintMessage(8,"bar"));
        Console.WriteLine(logger.ShouldPrintMessage(10,"foo"));
        Console.WriteLine(logger.ShouldPrintMessage(11,"foo"));
    }

    public class Logger
    {
        private readonly Dictionary<string,int> _messageTimestamps;
        public Logger()
        {
            _messageTimestamps = new Dictionary<string,int>();
        }

        public bool ShouldPrintMessage(int timestamp, string message)
        {
            if (_messageTimestamps.TryGetValue(message,out int value) && timestamp - value >=10 )
            {
                _messageTimestamps[message]=timestamp;
                return true;
            }
            return _messageTimestamps.TryAdd(message,timestamp);

        }
    }
}
