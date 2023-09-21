import java.util.*;

class Solution {
    // 이동 방향을 상수로 선언 (하, 우, 상, 좌 순서)
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    // 로봇의 방향을 상수로 선언 (가로, 세로)
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    public int solution(int[][] board) {
        int N = board.length;
        
        // 방문한 상태(위치와 방향)를 저장할 Set
        Set<Position> visited = new HashSet<>();
        // BFS를 위한 Queue
        Queue<Position> queue = new LinkedList<>();
        
        // 시작 위치와 방향 설정
        Position start = new Position(0, 0, HORIZONTAL, 0);
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            // 도착점에 도달했는지 확인
            if ((current.dir == HORIZONTAL && current.x == N - 2 && current.y == N - 1) ||
                (current.dir == VERTICAL && current.x == N - 1 && current.y == N - 2)) {
                return current.level;
            }

            // 로봇 이동
            for (int[] dir : DIRECTIONS) {
                Position newPos = current.move(dir, board);
                if (newPos != null && !visited.contains(newPos)) {
                    visited.add(newPos);
                    queue.offer(newPos);
                }
            }

            // 로봇 회전
            for (Position rotated : current.rotate(board)) {
                if (!visited.contains(rotated)) {
                    visited.add(rotated);
                    queue.offer(rotated);
                }
            }
        }

        return -1;
    }

    private static class Position {
        int x, y, dir, level;

        Position(int x, int y, int dir, int level) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.level = level;
        }

        // 지정된 방향으로 로봇을 이동시키는 메소드
        Position move(int[] direction, int[][] board) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            // 가로 방향일 경우의 이동 가능성 확인
            if (dir == HORIZONTAL) {
                if (0 <= nx && nx < board.length - 1 && 0 <= ny && ny < board.length && 
                    board[ny][nx] == 0 && board[ny][nx + 1] == 0) {
                    return new Position(nx, ny, dir, level + 1);
                }
            } 
            // 세로 방향일 경우의 이동 가능성 확인
            else {
                if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length - 1 && 
                    board[ny][nx] == 0 && board[ny + 1][nx] == 0) {
                    return new Position(nx, ny, dir, level + 1);
                }
            }

            return null;
        }

        // 로봇을 회전시키는 메소드 (가능한 모든 회전 방향을 반환)
        List<Position> rotate(int[][] board) {
            List<Position> rotations = new ArrayList<>();

            // 현재 가로 방향일 경우, 세로 방향으로 회전 가능한지 확인
            if (dir == HORIZONTAL) {
                if (y > 0 && board[y - 1][x] == 0 && board[y - 1][x + 1] == 0) {
                    rotations.add(new Position(x, y - 1, VERTICAL, level + 1));
                    rotations.add(new Position(x + 1, y - 1, VERTICAL, level + 1));
                }
                if (y < board.length - 1 && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0) {
                    rotations.add(new Position(x, y, VERTICAL, level + 1));
                    rotations.add(new Position(x + 1, y, VERTICAL, level + 1));
                }
            }
            // 현재 세로 방향일 경우, 가로 방향으로 회전 가능한지 확인
            else {
                if (x > 0 && board[y][x - 1] == 0 && board[y + 1][x - 1] == 0) {
                    rotations.add(new Position(x - 1, y, HORIZONTAL, level + 1));
                    rotations.add(new Position(x - 1, y + 1, HORIZONTAL, level + 1));
                }
                if (x < board.length - 1 && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0) {
                    rotations.add(new Position(x, y, HORIZONTAL, level + 1));
                    rotations.add(new Position(x, y + 1, HORIZONTAL, level + 1));
                }
            }

            return rotations;
        }

        // equals와 hashCode 메소드는 방문 처리를 위해 Position 객체의 동등성 비교를 제공
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y && dir == position.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, dir);
        }
    }
}
