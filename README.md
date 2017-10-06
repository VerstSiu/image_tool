# Image Tool

Image tool for android launcher and other icons.

## Features

* scale
* color

## Scale

Command line:

```java

java -jar lib.image_tool.jar scale {src} {dst_root} {dst_config}

```

Config:

```

{folder} {file_name} {size}
..

```

Sample:

<image alt="src" src="export/1.0/src/avatar-01.png" width="155" />

```

java -jar lib.image_tool.jar scale src/avatar-01.png icon_set/avatar_01 icon_set/scale_config.inf

```

```

res/mipmap-mdpi ic_launcher.png 48
res/mipmap-hdpi ic_launcher.png 72
res/mipmap-xhdpi ic_launcher.png 96
res/mipmap-xxhdpi ic_launcher.png 144
res/mipmap-xxxhdpi ic_launcher.png 192
. ic_launcher-web.png 512

```

<image alt="scale_output" src="screen_shots/scale_output.png" />

## Color

Command line:

```java

java -jar lib.image_tool.jar color {src|src_root} {dst_root} {dst_config}

```

Config:

```

[{suffix}] {color(like FF0000)}
..

```

Sample:

<image alt="src" src="export/1.0/src/title_icons/ic_alarm_add.png" />

```

java -jar lib.image_tool.jar color src/title_icons icon_pair/title_icons icon_pair/title_icon.inf

```

```

 cccccc
pressed 999999

```

<image alt="color_output" src="screen_shots/color_output.png" />

## License

```

   Copyright 2017 VerstSiu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```
