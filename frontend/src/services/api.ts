import axios from "axios";

const API_URL = "http://localhost:8080/api";

// Create axios instance
const apiClient = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

// Journal APIs
export const journalApi = {
  getEntries: () => apiClient.get("/journal/entries"),
  addEntry: (entry: { title: string; content: string; date: string }) =>
    apiClient.post("/journal/entries", entry),
  getEntry: (id: number) => apiClient.get(`/journal/entries/${id}`),
  updateEntry: (
    id: number,
    entry: { title: string; content: string; date: string }
  ) => apiClient.put(`/journal/entries/${id}`, entry),
  deleteEntry: (id: number) => apiClient.delete(`/journal/entries/${id}`),
};

// Task APIs
export const taskApi = {
  getTasks: () => apiClient.get("/tasks"),
  addTask: (task: { text: string; completed: boolean }) =>
    apiClient.post("/tasks", task),
  updateTask: (id: number, task: { text: string; completed: boolean }) =>
    apiClient.put(`/tasks/${id}`, task),
  deleteTask: (id: number) => apiClient.delete(`/tasks/${id}`),
};

// Skill Radar APIs
export const skillsApi = {
  getSkills: () => apiClient.get("/skills"),
  updateSkills: (
    skills: Array<{ subject: string; value: number; fullMark: number }>
  ) => apiClient.put("/skills", skills),
};

export default {
  journalApi,
  taskApi,
  skillsApi,
};
