package eu.tutorials.moviemagic.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import eu.tutorials.moviemagic.R
import eu.tutorials.moviemagic.databinding.FragmentDaySelectBinding
import eu.tutorials.moviemagic.ui.MovieViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DaySelectFragment : Fragment() {

    private var _binding: FragmentDaySelectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_day_select, container, false)
        binding.viewModel = viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirmDate.setOnClickListener {
            viewModel.calculateCost()
            findNavController().navigate(R.id.action_daySelectFragment_to_timeSelectFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}