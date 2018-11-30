package com.julu;

import java.util.Scanner;
public class test {
    private static int X;
    private static int Y;
    private static Car[] cars;
    enum Direction {
        N,W,S,E
    }
    static class Car {
        int id;
        Direction dir;
        int x;
        int y;
        public Car(int id,int x,int y,String strDir) {
            this.id = id+1;
            this.x = x;
            this.y = y;
            dir = Direction.valueOf(strDir);
        }
        public void move() {
            if(dir == Direction.N) {
                check(x,y+1);
                this.y += 1;
            } else if(dir == Direction.W) {
                check(x-1,y);
                this.x -= 1;
            } else if(dir == Direction.E) {
                check(x+1,y);
                this.x += 1;
            } else if(dir == Direction.S) {
                check(x,y-1);
                this.y -= 1;
            }
        }
        public void check(int x,int y){
            if(x>X || x<0 || y>Y || y<0) {
                System.out.println("小车"+this.id+"撞墙了");
                System.exit(0);
            }
            for(Car car : cars) {
                if(car.x==x && car.y==y) {
                    System.out.println("小车"+this.id+"撞到了小车"+car.id);
                    System.exit(0);
                }
            }
        }
        public void rotation(String str) {
            if(str.equals("L")) {
                if(dir == Direction.N) {
                    dir = Direction.W;
                } else if(dir == Direction.W) {
                    dir = Direction.S;
                } else if(dir == Direction.S) {
                    dir = Direction.E;
                }  else if(dir == Direction.E) {
                    dir = Direction.N;
                }
            } else {
                if(dir == Direction.N) {
                    dir = Direction.E;
                } else if(dir == Direction.W) {
                    dir = Direction.N;
                } else if(dir == Direction.S) {
                    dir = Direction.W;
                }  else if(dir == Direction.E) {
                    dir = Direction.S;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        X = scan.nextInt();
        Y = scan.nextInt();
        int n = scan.nextInt();
        int m = scan.nextInt();
        cars = new Car[n];
        for(int i=0;i<n;i++) {
            cars[i] = new Car(i,scan.nextInt(),scan.nextInt(),scan.next());
        }
        for(int i=0;i<m;i++) {
            int id = scan.nextInt();
            String command = scan.next();
            int time = scan.nextInt();
            for(int j=0;j<time;j++) {
                if(command.equals("F")) {
                    cars[id-1].move();
                } else {
                    cars[id-1].rotation(command);
                }
            }
        }
        System.out.println("Perfect");
        scan.close();
    }
}

