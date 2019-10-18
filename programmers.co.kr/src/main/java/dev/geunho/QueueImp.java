package dev.geunho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class myCode {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commandCapacity = br.readLine().split(" ");

        int numberOfCommands = Integer.valueOf(commandCapacity[0]);
        int capacity = Integer.valueOf(commandCapacity[1]);

        Queue Q = new Queue(capacity);

        for (int i = 0; i < numberOfCommands; i++) {
            String[] line = br.readLine().split(" ");

            Command command = Command.valueOf(line[0]);
            String parameter = line.length > 1 ? line[1] : "";

            Object resultOutput = "";

            switch (command) {
            case SIZE:
                resultOutput = Q.size();
                break;
            case OFFER:
                resultOutput = Q.offer(parameter);
                break;
            case TAKE:
                resultOutput = Q.take();
                break;
            }

            // stdout
            System.out.println(resultOutput);
        }
    }

    // 콘솔 응용 프로그램에서 사용하는 명령어 목록
    enum Command {
        SIZE, OFFER, TAKE,
    }
}

class Queue {
    private int capacity;
    private List<String> items;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    public String take() {
        if (items.isEmpty())
            return "";
        return items.remove(0);
    }

    public boolean offer(String item) {
        if (items.size() < capacity) {
            return items.add(item);
        }
        return false;
    }

    public int size() {
        return items.size();
    }
}