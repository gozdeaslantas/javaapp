# **Sentiment and Intent Analyzer**

The Sentiment and Intent Analyzer is a Python project that utilizes the Facebook BART (Bidirectional and Auto-Regressive Transformers) model for zero-shot text classification. It is designed to analyze dialog transcripts and determine sentiment and intent labels.

## **Table of Contents**
* [Installation](#Installation)
* [Usage](#Usage)
* [Project Structure](#Project-Structure)
* [Contributing](#Contributing)
* [License](#License)

## **Installation**
<a id="Installation"></a>

### **Prerequisites**
* Python 3.6 or higher
* [Facebook BART model](https://huggingface.co/facebook/bart-large) (model and configs should be placed in the resources/zero_shot_model directory)

### **Steps**
1. Clone the repository:
    ```
    git clone https://github.com/gozdeaslantas/sentiment-intent-analyzer.git
    ```
2. Navigate to the project directory:
    ```
    cd sentiment-intent-analyzer
    ```
3. Install the required dependencies:
    ```
    pip install -r requirements.txt
    ```
### **Usage**
<a id="Usage"></a>
1. Ensure the Facebook BART model is set up in the resources/zero_shot_model directory. If not, the code will be downloading the model in this directory.

2. Run the analysis using main.py:
    ```
    python main.py
    ```
The results will be displayed, showing sentiment and intent labels for the provided dialog transcripts.

1. If you want to use this code as a module run following code block:
    ```
    pip install setuptools wheel
    python setup.py sdist bdist_wheel
    ```
    
This block will create distribution version of the module.

### **Project Structure**
<a id="Project-Structure"></a>
* **config:** Contains config file where labels reside. 
* **data:** Contains transcript.json, a dialog file used for model classification.
* **resources/zero_shot_model:** Should include the Facebook BART model and its configurations.
* **src:** Contains sentiment_intention_analyzer.py, where the model is built, and analysis is performed.
* **main.py:** The main script to call the analyzer.
* **setup.py:** Configuration file for setuptools.

### **Contributing**
<a id="Contributing"></a>
Feel free to contribute to the project! Check out the [Contribution Guidelines](https://github.com/github/docs/blob/main/CONTRIBUTING.md) for more details.

### **License**
<a id="License"></a>
This project is licensed under the [MIT License](https://opensource.org/license/mit).
