import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    public int solution(int[][] board) {
        int N = board.length;
        
        Set<Position> visited = new HashSet<>();
        Queue<Position> queue = new LinkedList<>();
        
        Position start = new Position(0, 0, HORIZONTAL, 0);
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            // Check for goal condition
            if ((current.dir == HORIZONTAL && current.x == N - 2 && current.y == N - 1) ||
                (current.dir == VERTICAL && current.x == N - 1 && current.y == N - 2)) {
                return current.level;
            }

            // Move robot
            for (int[] dir : DIRECTIONS) {
                Position newPos = current.move(dir, board);
                if (newPos != null && !visited.contains(newPos)) {
                    visited.add(newPos);
                    queue.offer(newPos);
                }
            }

            // Rotate robot
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

        // Check if robot can move to new position
        Position move(int[] direction, int[][] board) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (dir == HORIZONTAL) {
                if (0 <= nx && nx < board.length - 1 && 0 <= ny && ny < board.length && 
                    board[ny][nx] == 0 && board[ny][nx + 1] == 0) {
                    return new Position(nx, ny, dir, level + 1);
                }
            } else {
                if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length - 1 && 
                    board[ny][nx] == 0 && board[ny + 1][nx] == 0) {
                    return new Position(nx, ny, dir, level + 1);
                }
            }

            return null;
        }

        // Rotate robot and return all possible positions after rotation
        List<Position> rotate(int[][] board) {
            List<Position> rotations = new ArrayList<>();

            // Horizontal to vertical rotations
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
            // Vertical to horizontal rotations
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
