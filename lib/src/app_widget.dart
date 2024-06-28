import 'package:background_tasks_flutter_playground/src/features/home/home_screen.dart';
import 'package:flutter/material.dart';

class AppWidget extends StatelessWidget {
  const AppWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: {
        '/':(context)=> const HomeScreen()
      },
    );
  }
}