package com.PolicyEditorBackend.PolicyEditor;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

@Component
public class ChartControlller {
    @FXML
    public LineChart<String, Double> chart;
}
