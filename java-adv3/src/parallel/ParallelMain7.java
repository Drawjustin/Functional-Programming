package parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {
    public static void main(String[] args) throws InterruptedException {
        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);

        // logic 전용 풀 추가
        ExecutorService logicPool = Executors.newFixedThreadPool(400);
        int nThreads = 3; // 1, 2, 3, 10, 20
        for (int i = 1; i <= nThreads; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100);
        }
        requestPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");

        long startTime = System.currentTimeMillis();
        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i,
                        requestName)))
                .toList();
        // Future 결과 취합
        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get(); } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).sum();

        es.close();
        long endTime = System.currentTimeMillis();
        log("[" + requestName + "] time: " + (endTime - startTime)+ "ms, sum:" + sum);
    }
}
