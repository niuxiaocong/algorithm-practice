package com.tixi.algorithm.course15;

import java.util.Arrays;
import java.util.Comparator;

public class Code01_MaxMeeting {
    public static void main(String[] args) {
        // 最大的会议场次
    }

    public static int maxMeet(Program[] programs){
        // 排序
        Arrays.sort(programs,new ProgramCompare());
        int timeLine = 0;
        int result = 0;
        for (int i = 0;i<programs.length;i++) {
          if (programs[i].start >= timeLine) {
              result++;
              timeLine = programs[i].end;
          }
        }
        return result;
    }

    public static class Program {
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramCompare implements Comparator<Program> {
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
