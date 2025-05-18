import React, { useState } from "react";
import {
  Button,
  TextField,
  Checkbox,
  List,
  ListItem,
  ListItemText,
  ListItemIcon,
  ListItemSecondaryAction,
  IconButton,
  Card,
  CardContent,
  Typography,
  Box,
} from "@mui/material";
import { Add as AddIcon, Delete as DeleteIcon } from "@mui/icons-material";

interface Task {
  id: number;
  text: string;
  completed: boolean;
}

const TaskList = () => {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [newTask, setNewTask] = useState("");

  const addTask = () => {
    if (newTask.trim()) {
      setTasks([
        ...tasks,
        {
          id: Date.now(),
          text: newTask,
          completed: false,
        },
      ]);
      setNewTask("");
    }
  };

  const toggleTask = (id: number) => {
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  };

  const deleteTask = (id: number) => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  return (
    <Card>
      <CardContent>
        <Typography variant="h5" component="div" gutterBottom>
          Quản lý nhiệm vụ
        </Typography>
        <Box sx={{ display: "flex", mb: 2 }}>
          <TextField
            fullWidth
            label="Thêm nhiệm vụ mới"
            variant="outlined"
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
            onKeyPress={(e) => e.key === "Enter" && addTask()}
          />
          <Button
            variant="contained"
            color="primary"
            startIcon={<AddIcon />}
            onClick={addTask}
            sx={{ ml: 1 }}
          >
            Thêm
          </Button>
        </Box>
        <List>
          {tasks.map((task) => (
            <ListItem
              key={task.id}
              dense
              button
              onClick={() => toggleTask(task.id)}
            >
              <ListItemIcon>
                <Checkbox
                  edge="start"
                  checked={task.completed}
                  tabIndex={-1}
                  disableRipple
                />
              </ListItemIcon>
              <ListItemText
                primary={task.text}
                sx={{
                  textDecoration: task.completed ? "line-through" : "none",
                  color: task.completed ? "text.disabled" : "text.primary",
                }}
              />
              <ListItemSecondaryAction>
                <IconButton
                  edge="end"
                  aria-label="delete"
                  onClick={() => deleteTask(task.id)}
                >
                  <DeleteIcon />
                </IconButton>
              </ListItemSecondaryAction>
            </ListItem>
          ))}
        </List>
      </CardContent>
    </Card>
  );
};

export default TaskList;
