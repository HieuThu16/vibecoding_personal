import React, { useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  Slider,
  Grid,
  Button,
  Box,
} from "@mui/material";
import {
  Radar,
  RadarChart,
  PolarGrid,
  PolarAngleAxis,
  PolarRadiusAxis,
  ResponsiveContainer,
} from "recharts";

interface Skill {
  subject: string;
  value: number;
  fullMark: number;
}

const DEFAULT_SKILLS: Skill[] = [
  { subject: "Sức khỏe", value: 5, fullMark: 10 },
  { subject: "Tài chính", value: 5, fullMark: 10 },
  { subject: "Sự nghiệp", value: 5, fullMark: 10 },
  { subject: "Mối quan hệ", value: 5, fullMark: 10 },
  { subject: "Phát triển cá nhân", value: 5, fullMark: 10 },
  { subject: "Tinh thần", value: 5, fullMark: 10 },
];

const SkillRadar = () => {
  const [skills, setSkills] = useState<Skill[]>(DEFAULT_SKILLS);

  const handleSkillChange = (index: number, newValue: number | number[]) => {
    const updatedSkills = [...skills];
    updatedSkills[index] = {
      ...updatedSkills[index],
      value: newValue as number,
    };
    setSkills(updatedSkills);
  };

  return (
    <Card>
      <CardContent>
        <Typography variant="h5" component="div" gutterBottom>
          Đánh giá các mặt của bản thân
        </Typography>
        <Box
          sx={{
            display: "flex",
            flexDirection: { xs: "column", md: "row" },
            alignItems: "center",
          }}
        >
          <Box
            sx={{
              width: "100%",
              height: 400,
              maxWidth: { xs: "100%", md: "50%" },
            }}
          >
            <ResponsiveContainer width="100%" height="100%">
              <RadarChart cx="50%" cy="50%" outerRadius="80%" data={skills}>
                <PolarGrid />
                <PolarAngleAxis dataKey="subject" />
                <PolarRadiusAxis angle={30} domain={[0, 10]} />
                <Radar
                  name="Đánh giá"
                  dataKey="value"
                  stroke="#8884d8"
                  fill="#8884d8"
                  fillOpacity={0.6}
                />
              </RadarChart>
            </ResponsiveContainer>
          </Box>
          <Box
            sx={{
              width: "100%",
              maxWidth: { xs: "100%", md: "50%" },
              mt: { xs: 3, md: 0 },
              pl: { xs: 0, md: 4 },
            }}
          >
            <Grid container spacing={2}>
              {skills.map((skill, index) => (
                <Grid item xs={12} key={skill.subject}>
                  <Typography gutterBottom>{skill.subject}</Typography>
                  <Slider
                    value={skill.value}
                    min={0}
                    max={10}
                    step={1}
                    valueLabelDisplay="auto"
                    onChange={(_, newValue) =>
                      handleSkillChange(index, newValue)
                    }
                  />
                </Grid>
              ))}
            </Grid>
          </Box>
        </Box>
      </CardContent>
    </Card>
  );
};

export default SkillRadar;
