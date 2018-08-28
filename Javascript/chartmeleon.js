function Chartmeleon() {
  this.getShades = function(hue, numberOfShades) {
    var lightness = 0;
    var saturation = 0;
    var lightnessSteps = numberOfShades === 1 ? 50 : 90 / numberOfShades;
    var saturationStepsDistance = 100 / Math.ceil(numberOfShades / 2);
    var shades = new Array();

    for (var i = 1; i <= numberOfShades; i++) {
      lightness += lightnessSteps;
      saturation += saturationStepsDistance;
      shades.push("hsl(" + hue + ", " + saturation + "%, " + lightness + "%)");
    }

    return shades;
  };

  this.getColorSet = function(numberOfHues, numberOfShades, random) {
    var hueStepDistance = 360 / numberOfHues;
    var hue = random === true ? Math.floor(Math.random() * 361) : 0;
    var colors = new Array();

    for (var i = 0; i < numberOfHues; i++) {
      colors.push(this.getShades(hue, numberOfShades));
      hue += hueStepDistance;
    }

    return colors;
  };
}
