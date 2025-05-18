import React, { useState } from "react";
import {
  Button,
  TextField,
  Card,
  CardContent,
  Typography,
  Box,
} from "@mui/material";
import { Save as SaveIcon } from "@mui/icons-material";

interface JournalEntryProps {
  onSave: (entry: { title: string; content: string; date: string }) => void;
}

const JournalEntry = ({ onSave }: JournalEntryProps) => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSave = () => {
    if (title.trim() && content.trim()) {
      onSave({
        title,
        content,
        date: new Date().toISOString(),
      });
      setTitle("");
      setContent("");
    }
  };

  return (
    <Card sx={{ mb: 3 }}>
      <CardContent>
        <Typography variant="h5" component="div" gutterBottom>
          Nhật ký hôm nay
        </Typography>
        <Box component="form" noValidate autoComplete="off" sx={{ mt: 2 }}>
          <TextField
            fullWidth
            label="Tiêu đề"
            variant="outlined"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            margin="normal"
          />
          <TextField
            fullWidth
            label="Nội dung"
            variant="outlined"
            value={content}
            onChange={(e) => setContent(e.target.value)}
            multiline
            rows={8}
            margin="normal"
          />
          <Button
            variant="contained"
            color="primary"
            startIcon={<SaveIcon />}
            onClick={handleSave}
            sx={{ mt: 2 }}
          >
            Lưu
          </Button>
        </Box>
      </CardContent>
    </Card>
  );
};

export default JournalEntry;
