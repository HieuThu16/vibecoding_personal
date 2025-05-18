import React, { useState } from "react";
import {
  Container,
  Grid,
  CssBaseline,
  Box,
  AppBar,
  Toolbar,
  Typography,
  ThemeProvider,
  createTheme,
} from "@mui/material";
import JournalEntry from "./components/journal/JournalEntry";
import TaskList from "./components/tasks/TaskList";
import SkillRadar from "./components/radar/SkillRadar";
import "./App.css";

// Định nghĩa kiểu dữ liệu cho Journal Entry
interface JournalEntryType {
  id: number;
  title: string;
  content: string;
  date: string;
}

const theme = createTheme({
  palette: {
    primary: {
      main: "#556cd6",
    },
    secondary: {
      main: "#19857b",
    },
    background: {
      default: "#f5f5f5",
    },
  },
});

function App() {
  const [journalEntries, setJournalEntries] = useState<JournalEntryType[]>([]);

  const handleSaveJournalEntry = (entry: {
    title: string;
    content: string;
    date: string;
  }) => {
    const newEntry = {
      id: Date.now(),
      ...entry,
    };
    setJournalEntries([newEntry, ...journalEntries]);
  };

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              Ứng dụng Quản lý Cá nhân
            </Typography>
          </Toolbar>
        </AppBar>
        <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
          <Grid container spacing={3}>
            <Grid item xs={12} md={6}>
              <JournalEntry onSave={handleSaveJournalEntry} />
              <Box sx={{ mt: 3 }}>
                <TaskList />
              </Box>
            </Grid>
            <Grid item xs={12} md={6}>
              <SkillRadar />
            </Grid>
          </Grid>
        </Container>
      </Box>
    </ThemeProvider>
  );
}

export default App;
