from transformers import pipeline
import configparser, os

class SentimentIntentionAnalyzer:
    def __init__(self, model_name="facebook/bart-large-mnli", config_path="config/sentiment_intention_config.ini"):
        model_path = './resources/zero_shot_model/'
        if os.path.exists(model_path):
            model_name = model_path
        self.classifier = pipeline(task = "zero-shot-classification", model=model_name)
        
        self.sentiment_labels, self.intent_labels = self.parse_ini_file(config_path)
        self.classifier.save_pretrained(model_path)

    def parse_ini_file(self, file_path):
        config = configparser.ConfigParser()
        config.read(file_path)

        self.sentiment_labels = config ['labels']['sentiments'].split('|')
        self.intent_labels = config ['labels']['intents'].split('|')

        return self.sentiment_labels, self.intent_labels

    def analyze_transcript(self, dialog):
        sentiment_preds = self.classifier(dialog, self.sentiment_labels, multi_label=True)    
        intent_preds = self.classifier(dialog, self.intent_labels, multi_label=True)
    
        return sentiment_preds['labels'][0], sentiment_preds['scores'][0], intent_preds['labels'][0], intent_preds['scores'][0]
