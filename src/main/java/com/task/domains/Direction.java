package com.task.domains;

public enum Direction {
  EAST {
    @Override
    public Direction left() {
      return Direction.NORTH;
    }

    @Override
    public Direction right() {
      return Direction.SOUTH;
    }
  },
  WEST {
    @Override
    public Direction left() {
      return Direction.SOUTH;
    }

    @Override
    public Direction right() {
      return Direction.NORTH;
    }
  },

  NORTH {
    @Override
    public Direction left() {
      return Direction.WEST;
    }

    @Override
    public Direction right() {
      return Direction.EAST;
    }
  },
  SOUTH {
    @Override
    public Direction left() {
      return Direction.EAST;
    }

    @Override
    public Direction right() {
      return Direction.WEST;
    }
  };

  public abstract Direction left();

  public abstract Direction right();
};
